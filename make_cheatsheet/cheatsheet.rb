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

class Draught
  attr_reader :displayname, :constructor_signatures, :comments
  def initialize(srcfile)
    classname = File.basename(srcfile).gsub(File.extname(srcfile), '')

    # package/ClassName, e.g. style/Fill
    @displayname = srcfile.gsub('src/draughts/', '').gsub(File.extname(srcfile), '')

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

class CheatsheetMaker
  include MarkdownHelper

  def timestamp
    DateTime.now.strftime("%Y-%m-%d %H:%M:%S %Z")
  end

  def draughts
    draught_files.sort.map { |draught| Draught.new(draught) }
  end

  private

  def draught_files
    Dir.glob('src/draughts/**/*.java') - ['src/draughts/Draught.java']
  end
end

filename = 'make_cheatsheet/template.html.erb'
template = ERB.new(File.read(filename))
template.filename = filename

# Strange: give CsM a #render, so a CsM instance is the binding:
template.def_method(CheatsheetMaker, 'render')

File.open('cheatsheet.html', 'w') do |f|
  f.puts CheatsheetMaker.new.render
end
