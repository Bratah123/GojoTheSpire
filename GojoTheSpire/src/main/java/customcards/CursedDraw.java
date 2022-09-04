package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.curses.CurseOfTheBell;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class CursedDraw extends CustomCard {
    public static final String NAME = "Cursed Draw";
    public static final String ID = "CursedDraw";
    public static final String DESCRIPTION = "Draw 4 cards and add a curse into the deck.";
    public static final String IMG_PATH = "img/gojo/cards/cursed_draw.jpg";
    public static final AbstractCard.CardRarity RARITY = CardRarity.COMMON;
    public static final AbstractCard.CardType CARD_TYPE = CardType.SKILL;
    private static final int COST = 1;
    private static final int UPGRADED_COST = 0;

    public CursedDraw() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE, AbstractCardEnum.GOJO_COLOR, RARITY, CardTarget.SELF);
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(UPGRADED_COST);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        if (abstractPlayer.drawPile.size() < 4) {
            // reshuffle discard into deck
            AbstractDungeon.actionManager.addToTop(new EmptyDeckShuffleAction());
        }
        AbstractCard curse = new CurseOfTheBell();
        abstractPlayer.drawPile.addToRandomSpot(curse);
        AbstractDungeon.actionManager.addToBottom(new AddCardToDeckAction(curse));
        CardCrawlGame.sound.playAV("CARD_DRAW_8", -0.12F, 0.25F);
        abstractPlayer.draw(4);
    }
}
