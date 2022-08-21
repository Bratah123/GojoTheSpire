package relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import constants.CardConstants;
import customcards.InfiniteVoid;

// This relic will store the amount of energy used in a combat and be used in some of Gojo's cards
public class GojoBlindfold extends CustomRelic {

    public static final String ID = "Gojo Blindfold";
    public static final String PATH_TO_IMG = "img/gojo/relics/gojo_blindfold.png";
    public static final String DESCRIPTION = "Stores all energy used in combat for skills and attacks.";

    public GojoBlindfold() {
        super(ID, PATH_TO_IMG, RelicTier.STARTER, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTION; // DESCRIPTIONS pulls from your localization file
    }

    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        super.onUseCard(targetCard, useCardAction);
        counter += targetCard.costForTurn;
        if (targetCard instanceof InfiniteVoid) {
            counter -= CardConstants.INFINTE_VOID_ENERGY_COST;
        }
    }

    @Override
    public boolean canPlay(AbstractCard card) {
        if (card instanceof InfiniteVoid && counter < CardConstants.INFINTE_VOID_ENERGY_COST) {
            return false;
        }
        return super.canPlay(card);
    }
}
