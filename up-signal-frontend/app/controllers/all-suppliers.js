import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Controller.extend(SweetAlertMixin,{
 _supplierService: service('suppliers-service'),
 supplierId: null,
 isChecked: false,
 session: Ember.inject.service('session'),

 avgRating: 0.0,

 actions: {
  deactivateSupplier: function(supplierId) {
    let sweetAlert = this.get('sweetAlert');
        sweetAlert({
            title: 'Jeste li sigurni da želite deaktivirati dobavljača',
            confirmButtonText: 'Da',
            showCancelButton: true,
            cancelButtonText: 'Ne',
            type: 'warning'
        }).then((confirm)=>{
            sweetAlert({
                title: 'Dobavljač je postao neaktivan',
                confirmButtonText: 'OK',
                type: 'success'
            }).then((confirm)=>{
              this.get('_supplierService').deactivateSupplier(supplierId).then(()=>{
                this.set('supplierId', null);
                this.get('target.router').refresh();  
              })
              })
        })
    },

    readRatingsSupplier: function(supplierId) {
    this.get('_supplierService').addRating(supplierId).then(()=>{
      this.get('target.router').refresh();
    })
    },
  showActive: function() {
    this.set('isChecked', !this.isChecked);
    if (this.isChecked) {
      this.get('_supplierService').getSuppliers('Aktivan').then((response) => {
        this.get('model').clear();
        this.get('model').pushObjects(response);
        console.log("AKTIVAN");
        console.log(response);
      });
    }
    else {
      this.get('_supplierService').getAllSuppliers().then((response) => {
        this.get('model').clear();
        this.get('model').pushObjects(response);
        console.log("NEAKTIVAN");
        console.log(response);

      });
    }

  },
  selectSort: function (value) {
    console.log("Select sort");
    this.get('_supplierService').getSortedSuppliers(value).then( (response) => {
      this.get('model').clear();
      this.get('model').pushObjects(response);
    })
  },

  rateSupplier: function(supplierId) {
    let sweetAlert = this.get('sweetAlert');
    let sweetAlertMixin = this.get('SweetAlertMixin');
    sweetAlert({
      html:
      '<div class="form-group">'+
      '<label for="exampleFormControlSelect1">Kategorija ocjenjivanja:</label>'+
      '<select class="form-control" id="categoryRating">'+
        '<option value="0">Kvalitet</option>'+
        '<option value="1">Brzina isporuke</option>'+
        '<option value="2">Komunikacija</option>'+
      '</select>'+
      '</div>'+
      '<div class="form-group">'+
        '<label>Ocjena</label>'+ // Popraviti ocjenjivanje da ide preko radio buttona
        '<select class="form-control" id="ratingForm">'+
        '<option value="0">1</option>'+
        '<option value="1">2</option>'+
        '<option value="2">3</option>'+
        '<option value="3">4</option>'+
        '<option value="4">5</option>'+
      '</select>'+
      '</div>'+

      '<div class="form-group">'+
        '<label> Komentar </label>'+
        '<textarea  class="form-control">'+
        '</textarea>'+
      '</div>',

      confirmButtonText: 'Ocjeni',
      showCancelButton: true,
      cancelButtonText: 'Odustani',
      type: 'info'
    }).then((confirm)=>{
      sweetAlert({
        title: 'Uspješno ocjenjen dobavljač',
        confirmButtonText: 'OK',
        type: 'success'
      })
    })
  },
}
});
