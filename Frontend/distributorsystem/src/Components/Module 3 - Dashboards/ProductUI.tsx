import React, { useEffect, useState } from 'react';
import axios from 'axios';

interface ProductData {
  id: number;
  name: string;
  unit: string;
  price: number;
  quantity: number;
  image: string;
}

const Product: React.FC = () => {
  const [products, setProducts] = useState<ProductData[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const fetchProducts = async () => {
    try {
      const response = await axios.get('http://localhost:8080/product/getAllProducts');
      setProducts(response.data);
    } catch (err) {
      setError('Error fetching products');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div className="product-list">
      {products.map((product) => (
        <div key={product.id} className="product-card">
          <img src={product.image} alt={product.name} />
          <h2>{product.name}</h2>
          <p>Unit: {product.unit}</p>
          <p>Price: ${product.price.toFixed(2)}</p>
          <p>Quantity: {product.quantity}</p>
        </div>
      ))}
    </div>
  );
};

export default Product;
