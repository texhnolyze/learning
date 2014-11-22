require 'spec_helper'

describe TemplateConverter do

  def simple_template
    "html\n  div\n    a\n"
  end

  def extended_template
    "html\n  div\n    div\n      a\n  div\nbody\n  div\n  div\n    div\n"
  end

  def converter(template = simple_template)
    TemplateConverter.new(template)
  end

  #let(:template){ "html\n  div\n    a\n  div\n" }

  describe '#new' do
    #it 'should take template string arg' do
      #expect(converter).to be_an_instance_of TemplateConverter
      #expect(converter.template).to eq(simple_template)
    #end
  end
  
  describe '#convert' do
    context 'convert turns template into array of html-entity blocks as arrays' do
      #it 'should put entity into previous one for greater indetation' do
        #expect(converter.convert).to eq([['html', ['div', ['a']]]])
      #end

      it 'should work over multiple levels of indetation' do
        expect(converter(extended_template).convert).to eq([['html', ['div', ['div', ['a']]], ['div']], ['body', ['div'], ['div', ['div']]]])
      end
    end
  end

end
