package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

// Exhaust one card draw 4
public class BlackVoid extends CustomCard {

    public static final String NAME = "Black Void";
    public static final String ID = "BlackVoid";
    public static final String DESCRIPTION = "Draw 4 cards and Exhaust 1 card.";
    public static final String IMG_PATH = "img/gojo/cards/gojo_black_hole.png";
    public static final AbstractCard.CardRarity RARITY = CardRarity.COMMON;
    public static final AbstractCard.CardType CARD_TYPE = CardType.SKILL;
    private static final int COST = 1;
    private static final int UPGRADED_COST = 0;


    public BlackVoid() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE, AbstractCardEnum.GOJO_COLOR, RARITY, CardTarget.SELF);
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(UPGRADED_COST);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        if (abstractPlayer.drawPile.size() < 4) {
            // reshuffle discard into deck
            AbstractDungeon.actionManager.addToTop(new EmptyDeckShuffleAction());
        }
        AbstractDungeon.actionManager.addToBottom(
                new SelectCardsInHandAction(1, "Pick one card to exhaust", (cards) -> {
                    AbstractCard card = cards.get(0);
                    AbstractDungeon.actionManager.addToBottom(
                            new ExhaustSpecificCardAction(card, AbstractDungeon.player.hand)
                    );
                })
        );
        CardCrawlGame.sound.playAV("CARD_DRAW_8", -0.12F, 0.25F);
        abstractPlayer.draw(4);
    }
}
