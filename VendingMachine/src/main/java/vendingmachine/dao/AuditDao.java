package vendingmachine.dao;

public interface AuditDao {

    public void writeAuditEntry(String entry) throws VendingMachineDaoEx;

}
