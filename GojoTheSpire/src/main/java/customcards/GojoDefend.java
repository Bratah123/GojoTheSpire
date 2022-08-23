package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class GojoDefend extends CustomCard {
    public static final String NAME = "Defend";
    public static final String ID = "GojoDefend";
    public static final String DESCRIPTION = "Gain !B! block.";
    public static final String IMG_PATH = "img/gojo/cards/gojo_red_barrier.jpg";
    public static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.BASIC;
    public static final AbstractCard.CardType CARD_TYPE = CardType.SKILL;
    private static final int COST = 2;
    private static final int BLOCK = 5;
    private static final int UPGRADED_BLOCK = 3;


    public GojoDefend() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE, AbstractCardEnum.GOJO_COLOR, RARITY, CardTarget.SELF);
        this.block = this.baseBlock = BLOCK;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(UPGRADED_BLOCK);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
    }
}
