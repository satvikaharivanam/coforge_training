import EmployeeCard from "./EmployeeCard";
import ProductCard from "./ProductCard";
import Student from "./Student";
import Welcome from "./Welcome";



function App() {
  return (
  <>
    <Welcome />
    <Student 
      name = "Satvika" 
      course = "Springboot"
      age = "21"
      city = "Hyderabad"
    />

    <Student 
      name = "Rahul" 
      course = "React"
      age = "22"
      city = "Bangalore"
    />

    <EmployeeCard 
      empId = "232"
      empName = "Satvika"
      empDept = "Finance"
      empDes = "Team Leader"
      empSal = "234000"
    />

    <EmployeeCard 
      empId = "202"
      empName = "Harshika"
      empDept = "Admin"
      empDes = "Sr. Manager"
      empSal = "240000"
    />

    <ProductCard 
      productName = "milk"
      price = "20"
      brand = "amul"
      rating = "7"
      stock = "89"
    />

    <ProductCard 
      productName = "paneer"
      price = "48"
      brand = "heritage"
      rating = "8"
      stock = "109"
    />

    <ProductCard 
      productName = "all fruits jam"
      price = "95"
      brand = "kissan"
      rating = "8"
      stock = "104"
    />

  </>
  );
}

export default App;
