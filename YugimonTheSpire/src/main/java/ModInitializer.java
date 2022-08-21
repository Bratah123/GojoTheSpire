import basemod.BaseMod;
import basemod.abstracts.CustomCard;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostDrawSubscriber;
import color.AbstractCardEnum;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import customcards.InfiniteVoid;

import java.util.ArrayList;
import java.util.List;

@SpireInitializer
public class ModInitializer implements PostDrawSubscriber, EditCardsSubscriber {


    public ModInitializer() {
        // Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribe(this);
        BaseMod.addColor(AbstractCardEnum.GOJO_COLOR,
                Color.PURPLE,
                "img/gojo/512/bg_attack_purple",
                "img/gojo/512/bg_skill_purple",
                "img/gojo/512/bg_power_purple",
                "img/gojo/512/card_purple_small_orb",
                "img/gojo/1024/bg_attack_purple",
                "img/gojo/1024/bg_skill_purple",
                "img/gojo/1024/bg_power_purple",
                "img/gojo/1024/card_purple_orb",
                "img/gojo/512/card_purple_orb"
                );
    }

    //Used by @SpireInitializer
    public static void initialize() {

        //This creates an instance of our classes and gets our code going after BaseMod and ModTheSpire initialize.
        ModInitializer modInitializer = new ModInitializer();

        //Look at the BaseMod wiki for getting started. (Skip the decompiling part. It's not needed right now)

    }

    @Override
    public void receivePostDraw(AbstractCard abstractCard) {
        System.out.println("Player just drew card: " + abstractCard.name);
    }

    @Override
    public void receiveEditCards() {
        System.out.println("Adding custom cards");
        List<CustomCard> cards = new ArrayList<>();
        cards.add(new InfiniteVoid());

        for (CustomCard card : cards) {
            BaseMod.addCard(card);
            UnlockTracker.unlockCard(card.cardID);
        }

        System.out.println("Finished adding custom cards");

    }
}
