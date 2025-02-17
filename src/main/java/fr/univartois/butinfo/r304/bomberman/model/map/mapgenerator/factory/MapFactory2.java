package fr.univartois.butinfo.r304.bomberman.model.map.mapgenerator.factory;

import fr.univartois.butinfo.r304.bomberman.model.map.GameMap;
import fr.univartois.butinfo.r304.bomberman.model.map.mapgenerator.generator.MapGenerator2;
import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

/**
 * La classe MapFactory2 est une fabrique de cartes pour le jeu Bomberman.
 * Elle utilise le générateur de cartes MapGenerator2 pour créer une carte.
 */
public class MapFactory2 implements IMapFactory {

    /**
     * La hauteur et la largeur de la carte en pixels.
     */
    private final int height;

    /**
     * La largeur de la carte en pixels.
     */
    private final int width;

    /**
     * Le magasin de sprites utilisé pour la carte.
     */
    private final ISpriteStore spriteStore;

    /**
     * Crée une nouvelle instance de MapFactory2.
     *
     * @param height      La hauteur de la carte en pixels.
     * @param width       La largeur de la carte en pixels.
     * @param spriteStore Le magasin de sprites utilisé pour la carte.
     */
    public MapFactory2(int height, int width, ISpriteStore spriteStore) {
        this.height = height;
        this.width = width;
        this.spriteStore = spriteStore;
    }

    /**
     * Crée une carte en utilisant le générateur de cartes MapGenerator2.
     *
     * @return La carte générée.
     */
    @Override
    public GameMap createMap() {
        return new MapGenerator2(height / spriteStore.getSpriteSize(), width / spriteStore.getSpriteSize()).genererMap();
    }
}