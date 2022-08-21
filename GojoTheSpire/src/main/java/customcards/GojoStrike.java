package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

// To replace the boring old strike
public class GojoStrike extends CustomCard {

    public static final String NAME = "Strike";
    public static final String ID = "GojoStrike";
    public static final String DESCRIPTION = "Deal !D! damage.";
    public static final String IMG_PATH = "img/gojo/cards/satoru_punches_volcano.png";
    public static final CardRarity RARITY = CardRarity.BASIC;
    public static final CardType CARD_TYPE = CardType.ATTACK;
    private static final int COST = 1;
    private static final int DAMAGE = 6;
    private static final int UPGRADED_DAMAGE = 2;

    public GojoStrike() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE, AbstractCardEnum.GOJO_COLOR, RARITY, CardTarget.ENEMY);
        this.damage = this.baseDamage = DAMAGE;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPGRADED_DAMAGE);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m,
                new DamageInfo(p, this.damage, this.damageTypeForTurn),
                AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
}
