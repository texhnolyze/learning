require_relative '../entities/html_entities'

class TemplateConverter
  include HtmlEntities

  attr_accessor :template

  def initialize(template)
    @template = template
  end

  def convert
    template_to_arr(template.split("\n"))
  end

  def template_to_arr(template_lines)
    template_arr = []
    template_lines.each_with_index do |line, index|
      if index == 0
        template_arr << [line]
      elsif (indentation(line) > indentation(template_lines[index - 1]))
        search_parent_entity(template_arr, line)  << [line]
      elsif (indentation(line) == indentation(template_lines[index - 1]))
        search_parent_entity(template_arr, line)  << [line]
        #template_arr.last << [line]
      elsif (indentation(line) < indentation(template_lines[index - 1]))
        if indentation(line) == 0
          template_arr << [line]
        else
          search_parent_entity(template_arr, line)  << [line]
        end
      end
    end
    trim_whitespace(template_arr)
  end

  def search_parent_entity(entity_array, entity)
    index = 0
    entity_array.reverse_each do |entry|
      puts "Run #{index} with entity #{entity} indentation #{indentation(entity)}"
      puts "Entry #{entry}"
      #entry = get_innermost_array_in_array(entry)
      puts "Innermost #{entry} indentation #{indentation(entry.first)}"
      if entry.kind_of(Array)
        entry = get_previous_entity_with_indetation(entry, indentation(entity) - 2)
      end

      return entry if indentation(entity) - 2 == indentation(entry.first)
      index += 1
    end
  end

  def get_previous_entity_with_indetation(entity_array, indetation_size)
    while (indentation(entity_array.last) != indetation_size)
      entity_array = get_next_array_in_array(entity_array)
    end
  end

  def get_next_array_in_array(array)
    array.last.first array.last.kind_of?(Array) || array.last
  end

  def get_innermost_array_in_array(array)
    if array.last.kind_of?(Array)
      get_innermost_array_in_array(array.last)
    else
      array
    end
  end

  def trim_whitespace(string_array)
    string_array.each do |entry|
      if entry.kind_of?(Array)
        trim_whitespace(entry)
      else
        entry.strip!
      end
    end
    string_array
  end

  def indentation(line)
    line[/^ */].size
  end

end
