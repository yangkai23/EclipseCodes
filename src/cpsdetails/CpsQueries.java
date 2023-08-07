package cpsdetails;

public final class CpsQueries {
	public static final String templateQuery = "SELECT cp.name,acquisition.acq_receipt_id,pci.id AS prep_id,pci.last_orchestration_id   AS workflow_id,substr(pci.content_info, instr(pci.content_info, '/', - 1, 1) + 1) AS filename,pci.content_info,pci.modified_date,acquisition.created_date,acquisition_status.acquisition_status,osd.status_desc,repreparewf.count,acquisition.probot_id,delivery_files.delivery_file_name "
			+ "FROM orchestrations ai "
			+ "LEFT JOIN (SELECT preparation_content_id,COUNT(repreparation_workflow) count   FROM orchestrations WHERE repreparation_workflow = 'Y'    \r\n"
			+ "GROUP BY preparation_content_id) repreparewf ON repreparewf.preparation_content_id = ai.preparation_content_id "
			+ "LEFT JOIN contentset_provider        cp ON cp.id = ai.contentset_provider_id "
			+ "LEFT JOIN orchestration_status_def   osd ON osd.id = ai.orchestration_status "
			+ "LEFT JOIN preparation_content_info   pci ON pci.last_orchestration_id = ai.id "
			+ "LEFT JOIN acquisition ON pci.acquisition_receipt_id = acquisition.acq_receipt_id "
			+ "LEFT JOIN acquisition_status ON acquisition.id = acquisition_status.acquisition_id "
			+ "LEFT JOIN orchestration_delivery_info ON pci.last_orchestration_id = orchestration_delivery_info.orchestration_id "
			+ "LEFT JOIN delivery_files ON orchestration_delivery_info.id = delivery_files.orch_delivery_id ";
	public static final String prepIdQuery = templateQuery + "\n WHERE pci.id IN (?)";
	public static final String receiptIdQuery = templateQuery + "\n WHERE ACQUISITION.ACQ_RECEIPT_ID in (?)";
	public static final String inputFileNameQuery = templateQuery
			+ "\n WHERE SUBSTR(PCI.CONTENT_INFO,INSTR(PCI.CONTENT_INFO,'/',-1,1)+1) in (?)";
	public static final String inputFileNameQueryUsingLike = templateQuery
			+ "\n WHERE SUBSTR(PCI.CONTENT_INFO,INSTR(PCI.CONTENT_INFO,'/',-1,1)+1) like ?";
	public static final String deliveryFileQuery = templateQuery + "\n WHERE DELIVERY_FILE_NAME in (?)";
	public static final String workflowIdQuery = templateQuery + "\n WHERE pci.last_orchestration_id IN  (?)";
	public static final String articleIDQuery = "select * from cps.ARTICLEMETADATA a where a.ARTICLEID in (?)";
	public static final String bundleAudit="select * from CPS.BUNDLE_AUDIT_E2E baee where FILENAME in (?)";
}
