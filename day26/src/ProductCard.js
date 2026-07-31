
function ProductCard(props) {
  return (
    <>
      <div className="card" style={{ width: "18rem" }}>
        <div className="card-body">
          <h5 className="card-title">Product Details</h5>

          <p className="card-text">
            <strong>Product Name :</strong> {props.productName}
          </p>

          <p className="card-text">
            <strong>Price :</strong> {props.price}
          </p>

          <p className="card-text">
            <strong>Brand :</strong> {props.brand}
          </p>

          <p className="card-text">
            <strong>Rating :</strong> {props.rating}
          </p>

          <p className="card-text">
            <strong>Stock Status :</strong> {props.stock}
          </p>
        </div>
      </div>
    </>
  )
}

export default ProductCard;