package tacos.Editors;

import org.springframework.util.StringUtils;
import tacos.models.Ingredient;
import tacos.repositories.IngredientRepository;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class IngredientEditor extends PropertyEditorSupport {

    private IngredientRepository ingredientRepository;

    public IngredientEditor(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public String getAsText() {
        Ingredient ingredient = (Ingredient) getValue();
        return ingredient.getId();
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        if (StringUtils.isEmpty(id)) {
            setValue(null);
        } else {
            setValue(ingredientRepository.findOne(id));
        }
    }
}
