package shark.server

import java.util.{Map => JMap}
import org.apache.hive.service.cli.operation.{ExecuteStatementOperation, OperationManager}
import org.apache.hive.service.cli.session.HiveSession

class SharkOperationManager extends OperationManager {
 override def newExecuteStatementOperation(parentSession: HiveSession,
                                           statement: String, confOverlay:
                                           JMap[String, String], runAsync: Boolean)
                                           : ExecuteStatementOperation = {
   val executeStatementOperation = SharkExecuteStatementOperation
     .newExecuteStatementOperation(parentSession, statement, confOverlay, false)
   val castOp = executeStatementOperation.asInstanceOf[ExecuteStatementOperation]
   addOperation(castOp)
   castOp
 }

}
