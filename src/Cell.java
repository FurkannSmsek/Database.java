public class Cell {

    private  int cellId,cellSize,cellCapacity,cellStuffCount,cellPrisonerCount;

    public Cell(int cellId, int cellSize, int cellCapacity, int cellStuffCount, int cellPrisonerCount) {
        this.cellId = cellId;
        this.cellSize = cellSize;
        this.cellCapacity = cellCapacity;
        this.cellStuffCount = cellStuffCount;
        this.cellPrisonerCount = cellPrisonerCount;
    }


    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public int getCellCapacity() {
        return cellCapacity;
    }

    public void setCellCapacity(int cellCapacity) {
        this.cellCapacity = cellCapacity;
    }

    public int getCellStuffCount() {
        return cellStuffCount;
    }

    public void setCellStuffCount(int cellStuffCount) {
        this.cellStuffCount = cellStuffCount;
    }

    public int getCellPrisonerCount() {
        return cellPrisonerCount;
    }

    public void setCellPrisonerCount(int cellPrisonerCount) {
        this.cellPrisonerCount = cellPrisonerCount;
    }
}
