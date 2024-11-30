package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.SpriteStore;
import javafx.stage.Stage;

import java.util.Random;

/**
 * La classe {@link GenerateurMap} permet de générer une carte de jeu.
 */
public abstract class GenerateurMap implements IGenerateurMap {
    private final int height;
    private final int width;
    protected SpriteStore spriteStore = SpriteStore.getInstance();
    private Stage stage;
    private final Random random;

    /**
     * Crée un générateur de carte de jeu.
     *
     * @param height La hauteur de la carte à générer.
     * @param width  La largeur de la carte à générer.
     */
    public GenerateurMap(int height, int width) {
        this.height = height;
        this.width = width;
        this.random = new Random();
    }


    /**
     * Génère une carte de jeu.
     *
     * @return La carte de jeu générée.
     */
    @Override
    public GameMap genererMap() {
        GameMap map = new GameMap(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map.setAt(i, j, generateCell(i, j));
            }
        }
        return map;
    }

    /**
     * Génère une cellule pour une position donnée.
     *
     * @param i La position en hauteur.
     * @param j La position en largeur.
     * @return La cellule générée.
     */
    protected abstract Cell generateCell(int i, int j);

    /**
     * Vérifie si une position est sur la bordure de la carte.
     *
     * @param i La position en hauteur.
     * @param j La position en largeur.
     * @return true si la position est sur la bordure, false sinon.
     */
    private boolean isBorder(int i, int j) {
        return i == 0 || j == 0 || i == height - 1 || j == width - 1;
    }

    /**
     * Vérifie si une position doit contenir un mur.
     *
     * @param i La position en hauteur.
     * @param j La position en largeur.
     * @return true si la position doit contenir un mur, false sinon.
     */
    private boolean isWallPosition(int i, int j) {
        return i % 3 == 0 && j % 3 == 0;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}