class Peice {

    enum Rank {elephant, lion, tiger, leopard, wolf, dog, cat, rat}
    enum Team {home, away}
    final Rank rank;
    final Team team;
    int x, y;

    Peice() {
        rank = null;
        team = null;
    }

    Peice(int x, int y, Team t, Rank r ) {
        this.x = x;
        this.y = y;
        this.team = t;
        this.rank = r;

    } 

}