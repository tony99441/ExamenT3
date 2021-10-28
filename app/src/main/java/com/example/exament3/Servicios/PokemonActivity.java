package com.example.exament3.Servicios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.exament3.Adapters.PokemonAdapter;
import com.example.exament3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);





        // Vinculamos la actividad de PokemonActivity

        RecyclerView rv = findViewById(R.id.rvPokemon);
        rv.setLayoutManager(new LinearLayoutManager(PokemonActivity.this));
        List<Pokemon>pokemons = GetPokemons();
        PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemons);
        rv.setAdapter(pokemonAdapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/pokemons/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
        service.all().enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {


            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });




    }




    private List<Pokemon> GetPokemons(){

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Pikachu","Tipo: Fuego","https://i.pinimg.com/736x/f4/95/52/f49552c63e353a6c2b73eada2f8f4671.jpg",7.1529261,-78.5092874 ));
        pokemons.add(new Pokemon("Vamo a Calmarno","Tipo: agua","https://i.pinimg.com/474x/7b/9d/df/7b9ddf692c6df64d86bbe4e96ef46a83--type-pokemon-pokemon-stuff.jpg",-7.160593,-78.521711 ));
        pokemons.add(new Pokemon("Bulbasaur","Tipo: Tierra","https://tecmoviles.com/wp-content/uploads/2016/09/evolucion-de-bulbasaur-todos-los-trucos-600x599.png",1,1 ));
        pokemons.add(new Pokemon("Charizard","Tipo: Fuego","https://cdn.custom-cursor.com/cursors/pokemon_charmander__and_charizard_893.png",-7.160593,-78.5217119 ));
        pokemons.add(new Pokemon("Wartortle","Tipo: Agua","https://w7.pngwing.com/pngs/143/481/png-transparent-pokemon-red-and-blue-pokemon-firered-and-leafgreen-wartortle-pokemon-tcg-online-drawing-of-pokemon-charmander-mammal-carnivoran-dog-like-mammal.png",-7.160593,-78.5217119 ));
        pokemons.add(new Pokemon("Ivysaur","Tipo: Fuego","https://i.pinimg.com/originals/ed/0a/f3/ed0af3039f95bcf2c800d0693a3e4113.png",-7.160593,-78.5217119 ));
        pokemons.add(new Pokemon("Rattata","Tipo: Tierra","https://w7.pngwing.com/pngs/700/390/png-transparent-pokemon-firered-and-leafgreen-rattata-pokemon-red-and-blue-raticate-idle-animations-purple-mammal-cat-like-mammal.png",-7.160593,-78.5217119 ));
        return pokemons;
    }



}