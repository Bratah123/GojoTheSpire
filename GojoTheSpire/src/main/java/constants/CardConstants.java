package constants;

import com.megacrit.cardcrawl.cards.AbstractCard;
import customcards.InfiniteVoid;
import customcards.InfinityBarrier;

public class CardConstants {
    // This stores the amount of energy stored in Blindfold relic to play the card
    public static final int INFINTE_VOID_ENERGY_COST = 25;

    public static boolean isBlindfoldEnergySkill(AbstractCard c) {
        return c instanceof InfiniteVoid || c instanceof InfinityBarrier;
    }
}
