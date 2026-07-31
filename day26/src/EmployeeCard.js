
function EmployeeCard(props) {
  return (
    <>
      <div className="card" style={{ width: "18rem" }}>
        <div className="card-body">
          <h5 className="card-title">Employee Details</h5>

          <p className="card-text">
            <strong>Employee ID :</strong> {props.empId}
          </p>

          <p className="card-text">
            <strong>Employee Name :</strong> {props.empName}
          </p>

          <p className="card-text">
            <strong>Employee Department :</strong> {props.empDept}
          </p>

          <p className="card-text">
            <strong>Employee Designation :</strong> {props.empDes}
          </p>

          <p className="card-text">
            <strong>Employee Salary :</strong> {props.empSal}
          </p>
        </div>
      </div>
    </>
  )
}

export default EmployeeCard;