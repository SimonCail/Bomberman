/**
 * Package contenant les classes du modèle représentant la carte du jeu.
 */
package fr.univartois.butinfo.r304.bomberman.model.map.wallState;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.GetGameInstance;
import fr.univartois.butinfo.r304.bomberman.model.bonus.BombBonus;
import fr.univartois.butinfo.r304.bomberman.model.bonus.InvincibilityBonus;
import fr.univartois.butinfo.r304.bomberman.model.bonus.LifeBonus;
import fr.univartois.butinfo.r304.bomberman.model.map.Wall;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import fr.univartois.butinfo.r304.bomberman.view.SpriteStore;

import java.util.Random;

/**
 * Classe représentant l'état d'un mur en brique fissuré.
 */
public class CrackedBrickWallState implements IWallState {
    private final Sprite sprite;
    private BombermanGame game = GetGameInstance.getInstance();
    private SpriteStore spriteStore = SpriteStore.getInstance();
    private Random random = new Random();

    /**
     * Crée un nouvel état de mur en brique fissuré.
     *
     * @param sprite Le sprite représentant le mur en brique fissuré.
     */
    public CrackedBrickWallState(Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Dégrade le mur.
     *
     * @param wall le mur à dégrader
     */
    @Override
    public void degrade(Wall wall) {
        int chance = random.nextInt(100);
        if (chance < 40) {
            BombBonus bombBonus = new BombBonus(game, wall.getPositionX(), wall.getPositionY(), spriteStore.getSprite("bombPlus"));
            game.addMovable(bombBonus);
            wall.setState(bombBonus);
        } else if (chance < 55) {
            LifeBonus lifeBonus = new LifeBonus(game, wall.getPositionX(), wall.getPositionY(), spriteStore.getSprite("heartPlus"));
            game.addMovable(lifeBonus);
            wall.setState(lifeBonus);
        } else if (chance < 60) {
            InvincibilityBonus invincibilityBonus = new InvincibilityBonus(game, wall.getPositionX(), wall.getPositionY(), spriteStore.getSprite("Invincibility-stars"));
            game.addMovable(invincibilityBonus);
            wall.setState(invincibilityBonus);
        }
    }

    /**
     * Récupère le sprite associé à l'état du mur.
     *
     * @return le sprite associé à l'état du mur
     */
    @Override
    public Sprite getSprite() {
        return sprite;
    }
}
