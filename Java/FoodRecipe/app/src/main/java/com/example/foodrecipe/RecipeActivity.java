package com.example.foodrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeActivity extends AppCompatActivity {

    ImageView imgMenu;
    TextView txtMenu;
    ListView listRecipe;
    String Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        imgMenu = (ImageView) findViewById(R.id.ImageMenu);
        txtMenu = (TextView) findViewById(R.id.TextMenu);
        listRecipe = (ListView) findViewById(R.id.ListRecipe);

        Intent getIntent = getIntent();
        Menu = getIntent.getStringExtra("Menu");

        if(Menu.equals("Menu1"))
        {
            imgMenu.setImageResource(R.drawable.spaghetti);
            txtMenu.setText("Spaghetti Carbonara");
            String[] recipe = {"1. 350 g (12 oz) of spaghetti",
            "2. 200 g (7 oz) of guanciale",
            "3. 4 whole medium eggs (1 egg each yeld)",
            "4. 100 g (1 cup + 1 tablespoon) of grated Pecorino Romano cheese",
            "5. ground black pepper"};
            ArrayAdapter<String> recipeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipe);

            listRecipe.setAdapter(recipeAdapter);
        }
        else if(Menu.equals("Menu2"))
        {
            imgMenu.setImageResource(R.drawable.beefstew);
            txtMenu.setText("Beef Stew");
            String[] recipe = {"1. 3 pounds boneless beef chuck (well-marbled), cut into 1½-inch pieces",
                    "2. 2 teaspoons salt",
                    "3. 1 teaspoon freshly ground black pepper",
                    "4. 3 tablespoons olive oil",
                    "5. 2 medium yellow onions, cut into 1-inch chunks",
                    "6. 7 cloves garlic, peeled and smashed",
            "7. 2 tablespoons balsamic vinegar",
            "8. 1½ tablespoons tomato paste",
            "9. ¼ cup all-purpose flour",
            "10. 2 cups dry red wine",
            "11. 2 cups beef broth",
            "12. 2 cups water",
            "13. 1 bay leaf",
            "14. ½ teaspoon dried thyme",
            "15. 1½ teaspoons sugar",
            "16. 4 large carrots, peeled and cut into 1-inch chunks on a diagonal",
            "17. 1 pound small white boiling potatoes (baby yukons), cut in half",
            "18. Fresh chopped parsley, for serving (optional)"};
            ArrayAdapter<String> recipeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipe);

            listRecipe.setAdapter(recipeAdapter);
        }
        else if(Menu.equals("Menu3"))
        {
            imgMenu.setImageResource(R.drawable.steak);
            txtMenu.setText("Steak");
            String[] recipe = {"1. 2 lbs New York Strip Steaks (2 steaks), or Ribeye or Top Sirloin Steaks (1 lb each steak, 1 1/4” thick)",
                    "2. 1/2 Tbsp vegetable oil, or any high heat cooking oil like canola or extra light olive oil",
                    "3. 1 1/2 tsp sea salt",
                    "4. 1 tsp black pepper, freshly ground",
                    "5. 2 Tbsp unsalted butter",
                    "6. 2 cloves garlic, peeled and quartered",
                    "7. 1 sprig fresh rosemary"};
            ArrayAdapter<String> recipeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipe);

            listRecipe.setAdapter(recipeAdapter);
        }
        else if(Menu.equals("Menu4"))
        {
            imgMenu.setImageResource(R.drawable.tteobokki);
            txtMenu.setText("tteokbokki");
            String[] recipe = {"1. 1 pound of cylinder shaped rice cake",
                    "2. 4 cups of water",
                    "3. 7 large size dried anchovies, with heads and intestines removed",
                    "4. 6 x 8 inch dried kelp",
                    "5. ⅓ cup hot pepper paste",
                    "6. 1 tablespoon Korean hot pepper flakes (gochugaru)",
                    "7. 1 tablespoon sugar",
                    "8. 3 green onions, cut into 3 inch long pieces",
                    "9. 2 hard boiled eggs, shelled (optional)",
                    "10. ½ pound fish cakes (optional)"};
            ArrayAdapter<String> recipeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipe);

            listRecipe.setAdapter(recipeAdapter);
        }
    }
}