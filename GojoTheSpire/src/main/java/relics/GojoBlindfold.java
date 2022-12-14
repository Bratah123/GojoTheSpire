package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatches;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import constants.CardConstants;
import customcards.InfiniteVoid;

import javax.smartcardio.Card;

// This relic will store the amount of energy used in a combat and be used in some of Gojo's cards
public class GojoBlindfold extends CustomRelic {

    public static final String ID = "GojoBlindfold";
    public static final String PATH_TO_IMG = "img/gojo/relics/gojo_blindfold.png";

    public GojoBlindfold() {
        super(ID, new Texture(PATH_TO_IMG), RelicTier.STARTER, LandingSound.MAGICAL);
        this.counter = 0;
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void atBattleStart() {
        counter = 0;
    }

    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        super.onUseCard(targetCard, useCardAction);
        counter += targetCard.costForTurn;
        if (CardConstants.isBlindfoldEnergySkill(targetCard)) {
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

    @Override
    public AbstractRelic makeCopy() {
        return new GojoBlindfold();
    }
}
