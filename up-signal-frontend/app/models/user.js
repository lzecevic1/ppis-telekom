import BaseModel from './base-model';

var _modelProperties = ['id', 'username', 'password', 'email', 'phoneNumber', 'gender'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});
