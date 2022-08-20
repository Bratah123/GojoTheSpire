import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.PostDrawSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;

@SpireInitializer
public class ModInitializer implements PostDrawSubscriber {


    public ModInitializer() {
        // Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribe((ISubscriber) this);
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
        abstractCard.damage = 99;
    }
}
