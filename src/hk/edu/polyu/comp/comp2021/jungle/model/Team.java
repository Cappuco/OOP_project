package hk.edu.polyu.comp.comp2021.jungle.model;

enum Team {
    Home("home"), Away("away");

    private String team;

    Team(String team) {
        this.team = team;
    }

    /**
     * Input: none
     * Output: String, team
     */
    public String getTeam() {
        return this.team;
    }

}
