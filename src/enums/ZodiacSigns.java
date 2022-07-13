package enums;

public enum ZodiacSigns {

    MOUSE(1, "쥐","쥐띠"){String tti(){return ZodiacSigns.MOUSE.tti;}},
    OX(2, "소","소띠"){String tti(){return ZodiacSigns.OX.tti;}},
    TIGER(3, "호랑이","호랑이띠"){String tti(){return ZodiacSigns.TIGER.tti;}},
    RABBIT(4, "토끼","토끼띠"){String tti(){return ZodiacSigns.RABBIT.tti;}},
    DRAGON(5, "용","용띠"){String tti(){return ZodiacSigns.DRAGON.tti;}},
    SNAKE(6, "뱀","뱀띠"){String tti(){return ZodiacSigns.SNAKE.tti;}},
    HORSE(7, "말","말띠"){String tti(){return ZodiacSigns.HORSE.tti;}},
    LAMB(8, "양","양띠"){String tti(){return ZodiacSigns.LAMB.tti;}},
    MONKEY(9, "원숭이","원숭이띠"){String tti(){return ZodiacSigns.MONKEY.tti;}},
    ROOSTER(10, "닭","닭띠"){String tti(){return ZodiacSigns.ROOSTER.tti;}},
    DOG(11, "개","개띠"){String tti(){return ZodiacSigns.DOG.tti;}},
    PIG(12, "돼지","돼지띠"){String tti(){return ZodiacSigns.PIG.tti;}};

    private final int numberOrder;
    private final String korean;
    private final String tti;

    ZodiacSigns(int numberOrder, String korean,String tti) {
        this.numberOrder = numberOrder;
        this.korean = korean;
        this.tti = tti;
    }

    abstract String tti();// 단순히 띠의 이름만 반환


    public int getNumberOrder() {
        return numberOrder;
    }

    public String getKorean() {
        return korean;
    }

    public String getTti() {
        return tti;
    }
}
