package customcards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import powers.InfiniteVoidPower;

public class InfiniteVoid extends CustomCard {

    public static final String ID = "InfiniteVoid";
    public static final String NAME = "Infinite Void";
    public static final String DESCRIPTION = "Gain 1 energy everytime you play a card. " +
            "Can only be played when 30 energy have been played this combat";
    public static final String IMG_PATH = "img/gojo/cards/infinite_void.png";
    public static final CardRarity RARITY = CardRarity.RARE;
    public static final CardType CARD_TYPE = CardType.POWER;
    private static final int COST = 8;
    private static final int UPGRADE_COST = 4;

    public InfiniteVoid() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE,
                AbstractCard.CardColor.GREEN, RARITY, AbstractCard.CardTarget.SELF);
        this.exhaust = true;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(UPGRADE_COST);
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new InfiniteVoid();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new ApplyPowerAction(p, p,
                        new InfiniteVoidPower(p), 1));
    }

}
