package wastelands.worldgen.biomes;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class WastelandsTemplate {
	private BiFunction<Double, Double, Integer> foliageColour;
    private BiFunction<Double, Double, Integer> grassColour;
    private BiFunction<Double, Double, Integer> waterColour;
    
    protected void biomeMaker(Biome.Builder maker) {
    	//void
    }
    protected void biomeGen(BiomeGenerationSettings.Builder generator) {
    	//void
    }
    protected void mobSpawner(MobSpawnInfo.Builder spawner) {
    	//void
    }
    protected void defaultMobSpawner(MobSpawnInfo.Builder spawner) {
    	spawner.isValidSpawnBiomeForPlayer();
    }
    
    public Biome build() {
    	Biome.Builder wastelandsBiome = new Biome.Builder();
    	
    	//Configure biome generation
    	BiomeGenerationSettings.Builder wastelandsGen = new BiomeGenerationSettings.Builder();
    	this.biomeGen(wastelandsGen);
    	wastelandsBiome.withGenerationSettings(wastelandsGen.build());
    	
    	//Configure mob spawning
    	MobSpawnInfo.Builder wastelandsSpawn = new MobSpawnInfo.Builder(); 
    	this.mobSpawner(wastelandsSpawn);
    	this.defaultMobSpawner(wastelandsSpawn);
    	wastelandsBiome.withMobSpawnSettings(wastelandsSpawn.build());
    	
    	//Build
    	this.biomeMaker(wastelandsBiome);
    	return wastelandsBiome.build();
    }
    
}
