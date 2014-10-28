class HtmlConverter
  include HtmlEntities
  
  def to_html_entity(entity, content)
    if self.constants.include?(entity)
      entity = create_div(entity) if entity.include?(/(#|.)/)
      "<#{entity}>#{content}</#{entity}" 
    end
  end

  def create_div(template_div)
    "div #{div_id(template_div)} #{div_class(template_div)}"
  end

  def div_class(string)
      create_class(entity.match(/\.\w/).gsub('.', ''))
  end

  def div_id(string)
      create_id(entity.match(/#\w/).gsub('.', ''))
  end

  def create_class(class_name)
    %(class="#{class_name}")
  end

  def create_id(id_name)
    %(id="#{id_name}")
  end
end
