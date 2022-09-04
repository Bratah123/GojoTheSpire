package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class EnergyStrike extends CustomCard {
    public static final String ID = "EnergyDefend";
    public static final String NAME = "Energy Defend";
    public static final String DESCRIPTION = "Deal !D! damage for every energy stored.";
    public static final String IMG_PATH = "img/gojo/cards/gojo_energy_strike.jpg";
    public static final CardRarity RARITY = CardRarity.COMMON;
    public static final CardType CARD_TYPE = CardType.SKILL;
    private static final int COST = 2;
    private static final int BASE_DMG = 1;
    private static final int UPGRADED_DMG = 2;

    public EnergyStrike() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE, AbstractCardEnum.GOJO_COLOR, RARITY, CardTarget.SELF);
        this.damage = this.baseDamage = BASE_DMG;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPGRADED_DMG);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m,
                new DamageInfo(p, this.damage * p.getRelic("GojoBlindfold").counter, this.damageTypeForTurn),
                AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
}
