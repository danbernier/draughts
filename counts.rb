# make a...bidirectional graph of numbers
# n = 3..12
#
# bidi edges from n to:
# n x 2
# n x 3
# n x 4
# n x 2/3
# n x 4/3
# n + 3
#
# Then, random-walk the shit out of it, and count visitations, and display them
# as percentages.

require 'pp'
require 'set'

class NumberGraph
  def initialize
    @graph = {}
    
    3.upto(12).each do |n|
      @graph[n] = Set.new
    end

    relationships = [
      lambda { |n| n * 2 },    # 1/2
      lambda { |n| n * 3 },    # 1/3
      lambda { |n| n * 4 },    # 1/4
      lambda { |n| n * 1.5 },  # 2/3
      lambda { |n| n * 0.75 }, # 4/3
      lambda { |n| n + 3 },
    ]

    3.upto(12).each do |n|
      relationships.each do |rel|
        other = rel[n]

        # if it's in the range, and it's an integer...
        if @graph.key?(other.round) && other.round == other && other != n
          other = other.round
          @graph[n].add(other)
          @graph[other].add(n)
        end
      end
    end

    # It may not be fully connected, but at least remove the totally
    # disconnected nodes:
    @graph.reject! { |k, v| v.empty? }

    pp @graph
  end

  def random_walk(n = 100)
    counts = {}

    # x marks the spot
    x = @graph.keys.sample

    n.times do
      # Record:
      counts[x] = (counts[x] || 0) + 1
      # Move:
      x = @graph[x].to_a.sample
    end

    counts
  end
end

def print_histogram(hash)
  # pp hash

  max = hash.values.max.to_f
  hash.sort_by(&:first).each do |key, value|
    barcount = (value / max) * 80
    bar = '#' * barcount.ceil
    puts key.to_s.rjust(3) + ' ' + bar
  end
end

print_histogram(NumberGraph.new.random_walk(100000))
