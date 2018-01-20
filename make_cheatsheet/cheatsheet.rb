# This runs from root dir, not ./make_cheatsheet.

require 'date'
require 'erb'
markdown_success = require 'kramdown'
raise "No Markdown processor installed!" unless markdown_success

module MarkdownHelper
  def md(markdown_src)
    Kramdown::Document.new(markdown_src).to_html
  end
end

class JavaClass
  attr_reader :displayname, :constructor_signatures, :comments
  def initialize(srcfile)
    classname = File.basename(srcfile).gsub(File.extname(srcfile), '')

    # package/ClassName, e.g. style/Fill
    @displayname = srcfile.gsub('src/draughts/', '').gsub('src/signals/', '').gsub(File.extname(srcfile), '')

    src = File.read(srcfile)
    @constructor_signatures = extract_constructor_signatures(src, classname).map { |sig|
      format_constructor_signature(sig, classname)
    }.sort
    @comments = scrub_comments(src.scan(/\/\*cheat(.*?)\*\//m).flatten.join(''))
  end

  private

  def format_constructor_signature(signature, classname)
    "`new #{classname}(#{signature})`"  # backticks for markdown
  end

  def extract_constructor_signatures(src, classname)
    src.scan(/public #{classname}\s*\((.*)\)/).flatten
  end

  def scrub_comments(comments)
    comments.split(/^\s*\*/).map(&:strip).join("\n")
  end
end

class PackageRenderer
  include MarkdownHelper

  def initialize(timestamp, all_packages, package_name)
    @timestamp = timestamp
    @all_packages = all_packages # for the menu
    @package_name = package_name
  end

  def package_menu
    @all_packages.sort.map { |p| "[#{p}](#{p})" }.join(' | ')
  end

  def package
    @package_name
  end

  def timestamp
    @timestamp.strftime("%Y-%m-%d %H:%M:%S %Z")
  end

  def java_classes
    files(@package_name).sort.map { |file| JavaClass.new(file) }
  end

  private

  def files(package_name)
    matching_class_name = package_name[0..-2].capitalize
    Dir.glob("src/#{package_name}/**/*.java") - ["src/draughts/#{matching_class_name}.java"]
  end
end

class CheatsheetMaker
  def toplevel_packages
    Dir.new('src').to_a.reject { |d| ['.', '..'].include?(d) }
  end

  def render
    filename = 'make_cheatsheet/template.md.erb'
    template = ERB.new(File.read(filename))
    template.filename = filename

    # Strange: give PackageRenderer a #render, so a PackageRenderer instance is the binding:
    template.def_method(PackageRenderer, 'render')

    now = DateTime.now
    all_packages = toplevel_packages
    all_packages.each do |package_name|
      File.open("docs/#{package_name}.md", 'w') do |f|
        f.puts PackageRenderer.new(now, all_packages, package_name).render
      end
    end
  end
end

CheatsheetMaker.new.render
