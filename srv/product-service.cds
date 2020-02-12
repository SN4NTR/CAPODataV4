using { com.leverx.products as db } from '../db/models';

service ProductService {

    entity Products as projection on db.Products;
}