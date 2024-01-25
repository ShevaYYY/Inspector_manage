package myClusses;

public class result {

    private String declaration, opir_izolation, nakaz_vidpovidalnogo,nakaz_rezhum, instruction,plan_evacuation, jornals_instruktaj;
    private String extinguishers, kran_komplect,evacuation_ways,sygnalization,electroobladnannz ;

public result(){};
    public result(String declaration, String opir_izolation, String nakaz_vidpovidalnogo, String nakaz_rezhum,
                  String instruction, String plan_evacuation, String jornals_instruktaj, String extinguishers, String kran_komplect,
                  String evacuation_ways, String sygnalization, String electroobladnannz) {
        this.declaration = declaration;
        this.opir_izolation = opir_izolation;
        this.nakaz_vidpovidalnogo = nakaz_vidpovidalnogo;
        this.nakaz_rezhum = nakaz_rezhum;
        this.instruction = instruction;
        this.jornals_instruktaj = jornals_instruktaj;
        this.extinguishers = extinguishers;
        this.kran_komplect = kran_komplect;
        this.evacuation_ways = evacuation_ways;
        this.sygnalization = sygnalization;
        this.electroobladnannz = electroobladnannz;
        this.plan_evacuation=plan_evacuation;
    }


    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getOpir_izolation() {
        return opir_izolation;
    }

    public void setOpir_izolation(String opir_izolation) {
        this.opir_izolation = opir_izolation;
    }

    public String getNakaz_vidpovidalnogo() {
        return nakaz_vidpovidalnogo;
    }

    public void setNakaz_vidpovidalnogo(String nakaz_vidpovidalnogo) {
        this.nakaz_vidpovidalnogo = nakaz_vidpovidalnogo;
    }

    public String getNakaz_rezhum() {
        return nakaz_rezhum;
    }

    public void setNakaz_rezhum(String nakaz_rezhum) {
        this.nakaz_rezhum = nakaz_rezhum;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getJornals_instruktaj() {
        return jornals_instruktaj;
    }

    public void setJornals_instruktaj(String jornals_instruktaj) {
        this.jornals_instruktaj = jornals_instruktaj;
    }

    public String getExtinguishers() {
        return extinguishers;
    }

    public void setExtinguishers(String extinguishers) {
        this.extinguishers = extinguishers;
    }

    public String getKran_komplect() {
        return kran_komplect;
    }

    public void setKran_komplect(String kran_komplect) {
        this.kran_komplect = kran_komplect;
    }

    public String getEvacuation_ways() {
        return evacuation_ways;
    }

    public void setEvacuation_ways(String evacuation_ways) {
        this.evacuation_ways = evacuation_ways;
    }

    public String getSygnalization() {
        return sygnalization;
    }

    public void setSygnalization(String sygnalization) {
        this.sygnalization = sygnalization;
    }

    public String getElectroobladnannz() {
        return electroobladnannz;
    }

    public void setElectroobladnannz(String electroobladnannz) {
        this.electroobladnannz = electroobladnannz;
    }

    public String getPlan_evacuation() {
        return plan_evacuation;
    }

    public void setPlan_evacuation(String plan_evacuation) {
        this.plan_evacuation = plan_evacuation;
    }
}
