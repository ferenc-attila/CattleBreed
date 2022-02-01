package breed.cattle;

public class CattleProperties {

    private String palate;
    private String color;
    private String formOfHorn;
    private String sex;
    private String name;
    private Parents parents;
    private String notes;

    public CattleProperties(String sex) {
        this.sex = sex;
    }

    public CattleProperties(String sex, Parents parents) {
        this(sex);
        this.parents = parents;
    }

    public CattleProperties(String palate, String color, String formOfHorn, String sex, String name, Parents parents, String notes) {
        this(sex, parents);
        this.palate = palate;
        this.color = color;
        this.formOfHorn = formOfHorn;
        this.name = name;
        this.notes = notes;
    }

    public CattleProperties(CattleProperties cattleProperties) {
        palate = cattleProperties.palate;
        color = cattleProperties.color;
        formOfHorn = cattleProperties.formOfHorn;
        sex = cattleProperties.sex;
        name = cattleProperties.name;
        parents = new Parents(cattleProperties.parents);
        notes = cattleProperties.notes;
    }

    public String getPalate() {
        return palate;
    }

    public void setPalate(String palate) {
        this.palate = palate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFormOfHorn() {
        return formOfHorn;
    }

    public void setFormOfHorn(String formOfHorn) {
        this.formOfHorn = formOfHorn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parents getParents() {
        return new Parents(parents);
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
