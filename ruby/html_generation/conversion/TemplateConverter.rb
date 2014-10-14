require '../entities/entity_definition.rb'

class TemplateConverter
  include Html_Entities

  attr_accessor :template

  def initialize(template)
    template = template
  end

  def convert
    sorted_lines = sort(template.split('\n'))
    sorted_lines.each { |line| to_html_entity(entity) }
  end

  def sort(lines)
    lines.sort do |a, b| 
      indetation(a) <=> indetation(b)
    end
  end

  def indetation(line)
    line[/\A */].size
  end
end
