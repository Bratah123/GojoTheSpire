package customclasses;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.Prefs;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.screens.stats.CharStat;
import customclasses.enums.GojoClassEnum;

import java.util.ArrayList;

public class Gojo extends AbstractPlayer {
    public static final int ENERGY_PER_TURN = 8; // how much energy you get every turn
    public static final String MY_CHARACTER_SHOULDER_2 = "img/char/shoulder2.png"; // campfire pose
    public static final String MY_CHARACTER_SHOULDER_1 = "img/char/shoulder1.png"; // another campfire pose
    public static final String MY_CHARACTER_CORPSE = "img/char/corpse.png"; // dead corpse
    public static final String MY_CHARACTER_SKELETON_ATLAS = "img/char/skeleton.atlas"; // spine animation atlas
    public static final String MY_CHARACTER_SKELETON_JSON = "img/char/skeleton.json"; // spine animation json
    public static final int STARTING_HP = 75;
    public static final int MAX_HP = 75;
    public static final int STARTING_GOLD = 99;
    public static final int HAND_SIZE = 2;
    private static final int ORB_SLOTS = 8;

    public Gojo(String name, PlayerClass chosenClass) {
        super(name, chosenClass);
        this.dialogX = (this.drawX + 0.0F * Settings.scale); // set location for text bubbles
        this.dialogY = (this.drawY + 220.0F * Settings.scale); // you can just copy these values

        initializeClass(null, MY_CHARACTER_SHOULDER_2, // required call to load textures and setup energy/loadout
                MY_CHARACTER_SHOULDER_1,
                MY_CHARACTER_CORPSE,
                getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));

        loadAnimation(MY_CHARACTER_SKELETON_ATLAS, MY_CHARACTER_SKELETON_JSON, 1.0F); // if you're using modified versions of base game animations or made animations in spine make sure to include this bit and the following lines

        AnimationState.TrackEntry e = this.state.setAnimation(0, "animation", true);
        e.setTime(e.getEndTime() * MathUtils.random());
    }

    @Override
    public String getPortraitImageName() {
        return "Gojo Satorou";
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> startingDeck = new ArrayList<>();
        startingDeck.add("MyCard0");
        startingDeck.add("MyCard0");
        startingDeck.add("MyCard0");
        startingDeck.add("MyCard0");
        startingDeck.add("MyCard1");
        startingDeck.add("MyCard1");
        startingDeck.add("MyCard1");
        startingDeck.add("MyCard1");
        startingDeck.add("MyCard2");
        return startingDeck;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        return new ArrayList<>();
    }

    @Override
    public CharSelectInfo getLoadout() {
        return null;
//        new CharSelectInfo("Gojo Satorou", "He is the greatest Sorcerer in the JJK Verse.",
//                STARTING_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, HAND_SIZE,
//                GojoClassEnum.GOJO, getStartingRelics(), getStartingDeck(), false);
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return null;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return null;
    }

    @Override
    public Color getCardRenderColor() {
        return null;
    }

    @Override
    public String getAchievementKey() {
        return null;
    }

    @Override
    public ArrayList<AbstractCard> getCardPool(ArrayList<AbstractCard> arrayList) {
        return null;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;
    }

    @Override
    public Color getCardTrailColor() {
        return null;
    }

    @Override
    public String getLeaderboardCharacterName() {
        return null;
    }

    @Override
    public Texture getEnergyImage() {
        return null;
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 0;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return null;
    }

    @Override
    public void renderOrb(SpriteBatch spriteBatch, boolean b, float v, float v1) {

    }

    @Override
    public void updateOrb(int i) {

    }

    @Override
    public Prefs getPrefs() {
        return null;
    }

    @Override
    public void loadPrefs() {

    }

    @Override
    public CharStat getCharStat() {
        return null;
    }

    @Override
    public int getUnlockedCardCount() {
        return 0;
    }

    @Override
    public int getSeenCardCount() {
        return 0;
    }

    @Override
    public int getCardCount() {
        return 0;
    }

    @Override
    public boolean saveFileExists() {
        return false;
    }

    @Override
    public String getWinStreakKey() {
        return null;
    }

    @Override
    public String getLeaderboardWinStreakKey() {
        return null;
    }

    @Override
    public void renderStatScreen(SpriteBatch spriteBatch, float v, float v1) {

    }

    @Override
    public void doCharSelectScreenSelectEffect() {

    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return null;
    }

    @Override
    public Texture getCustomModeCharacterButtonImage() {
        return null;
    }

    @Override
    public CharacterStrings getCharacterString() {
        return null;
    }

    @Override
    public String getLocalizedCharacterName() {
        return null;
    }

    @Override
    public void refreshCharStat() {

    }

    @Override
    public AbstractPlayer newInstance() {
        return null;
    }

    @Override
    public TextureAtlas.AtlasRegion getOrb() {
        return null;
    }

    @Override
    public String getSpireHeartText() {
        return null;
    }

    @Override
    public Color getSlashAttackColor() {
        return null;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    @Override
    public String getVampireText() {
        return null;
    }
}
