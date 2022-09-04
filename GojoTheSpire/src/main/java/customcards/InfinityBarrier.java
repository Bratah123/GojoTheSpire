package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import constants.CardConstants;
import powers.InfinityBarrierPower;

public class InfinityBarrier extends CustomCard {

    public static final String ID = "InfinityBarrier";
    public static final String NAME = "Infinity Barrier";
    public static final String DESCRIPTION = "Gain 6 block everytime you play a card. " +
            "Can only be played when " + CardConstants.INFINTE_VOID_ENERGY_COST + " energy have been played this combat";
    public static final String IMG_PATH = "img/gojo/cards/gojo_infinity_barrier.png";
    public static final CardRarity RARITY = CardRarity.RARE;
    public static final CardType CARD_TYPE = CardType.POWER;
    private static final int COST = 4;
    private static final int UPGRADE_COST = 2;

    public InfinityBarrier() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE,
                AbstractCardEnum.GOJO_COLOR, RARITY, AbstractCard.CardTarget.SELF);
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(UPGRADE_COST);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(
                new ApplyPowerAction(p, p,
                        new InfinityBarrierPower(p), 1));
    }
}
