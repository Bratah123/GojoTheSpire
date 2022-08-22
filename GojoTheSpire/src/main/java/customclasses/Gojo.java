package customclasses;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import color.AbstractCardEnum;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import customcards.InfiniteVoid;

import java.util.ArrayList;

public class Gojo extends CustomPlayer {
    public static final int ENERGY_PER_TURN = 8; // how much energy you get every turn
    public static final String MY_CHARACTER_SHOULDER_2 = "img/gojo/char/shoulder2.png"; // campfire pose
    public static final String MY_CHARACTER_SHOULDER_1 = "img/gojo/char/shoulder.png"; // another campfire pose
    public static final String MY_CHARACTER_CORPSE = "img/gojo/char/corpse.png"; // dead corpse
    public static final int STARTING_HP = 40;
    public static final int MAX_HP = 40;
    public static final int STARTING_GOLD = 99;
    public static final int HAND_SIZE = 2;
    private static final int ORB_SLOTS = 8;
    public static final String[] ORB_TEXTURES = {
            "img/gojo/char/orb/layer1.png",
            "img/gojo/char/orb/layer2.png",
            "img/gojo/char/orb/layer3.png",
            "img/gojo/char/orb/layer4.png",
            "img/gojo/char/orb/layer5.png",
            "img/gojo/char/orb/layer6.png",
            "img/gojo/char/orb/layer1d.png",
            "img/gojo/char/orb/layer2d.png",
            "img/gojo/char/orb/layer3d.png",
            "img/gojo/char/orb/layer4d.png",
            "img/gojo/char/orb/layer5d.png"
    };
    public static final Color PURPLE = CardHelper.getColor(139.0f, 0.0f, 139.0f);;

    public Gojo(String name, PlayerClass chosenClass) {
        super(name,
                chosenClass,
                ORB_TEXTURES,
                "img/gojo/char/orb/vfx.png",
                new SpriterAnimation("img/gojo/char/animation.scml")
        );
        initializeClass(null, MY_CHARACTER_SHOULDER_2, // required call to load textures and setup energy/loadout
                MY_CHARACTER_SHOULDER_1,
                MY_CHARACTER_CORPSE,
                getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
    }

    @Override
    public String getPortraitImageName() {
        return "Gojo Satorou";
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> startingDeck = new ArrayList<>();
        startingDeck.add("GojoStrike");
        startingDeck.add("GojoStrike");
        startingDeck.add("GojoStrike");
        startingDeck.add("GojoStrike");
        startingDeck.add("GojoStrike");
        startingDeck.add("GojoDefend");
        startingDeck.add("GojoDefend");
        startingDeck.add("GojoDefend");
        startingDeck.add("GojoDefend");
        startingDeck.add("GojoDefend");
        startingDeck.add("InfniteVoid");
        return startingDeck;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> startingRelics = new ArrayList<>();
        startingRelics.add("GojoBlindfold");
        return startingRelics;
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo("Gojo Satorou", "He is the strongest Sorcerer in the JJK Verse.",
                STARTING_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, HAND_SIZE,
                this, getStartingRelics(), getStartingDeck(), false);
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return "Gojo Satoru";
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.GOJO_COLOR;
    }

    @Override
    public Color getCardRenderColor() {
        return PURPLE;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new InfiniteVoid();
    }

    @Override
    public Color getCardTrailColor() {
        return PURPLE;
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontPurple;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("UNLOCK_PING", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT,
                false);
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "UNLOCK_PING";
    }

    @Override
    public String getLocalizedCharacterName() {
        return "Gojo Satoru";
    }

    @Override
    public AbstractPlayer newInstance() {
        return new Gojo(name, chosenClass);
    }

    @Override
    public String getSpireHeartText() {
        return "Even Gojo couldn't kill the heart...";
    }

    @Override
    public Color getSlashAttackColor() {
        return PURPLE;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    @Override
    public String getVampireText() {
        return "Vampire Gojo mmmm tasty.";
    }
}
