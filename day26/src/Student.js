
function Student(props){
  return(
    <>
      {/* <h4>Student Details</h4>
      <p>Name : {props.name}</p>
      <p>Name : {props.course}</p>
      <p>Name : {props.age}</p>
      <p>Name : {props.city}</p>
      <br /> */}

      <div className="card" style={{ width: "18rem" }}>
  <div className="card-body">
    <h5 className="card-title">Student Details</h5>

    <p className="card-text">
      <strong>Name:</strong> {props.name}
    </p>

    <p className="card-text">
      <strong>Course:</strong> {props.course}
    </p>

    <p className="card-text">
      <strong>Age:</strong> {props.age}
    </p>

    <p className="card-text">
      <strong>City:</strong> {props.city}
    </p>
  </div>
</div>
    </>
  )
}

export default Student;