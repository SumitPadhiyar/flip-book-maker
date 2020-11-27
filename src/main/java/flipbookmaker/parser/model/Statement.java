package flipbookmaker.parser.model;

public abstract class Statement {
    private int pages;

    Statement(int pages){
        this.pages = pages;
    } 

    public abstract StatementType getType();

    public int getNoOfPages(){
        return pages;
    }
}
