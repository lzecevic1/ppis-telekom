import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';
const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Controller.extend(SweetAlertMixin, {
  _packageService: service('package-service'),
  session: Ember.inject.service('session'),
  packageId: null,
  actions:{
    addPackage(){
      let sweetAlert = this.get('sweetAlert');
      sweetAlert({
        title: "Uspio",
      })
    },
    deactivatePackage: function(packageId) {
      let sweetAlert = this.get('sweetAlert');
          sweetAlert({
              title: 'Jeste li sigurni da želite deaktivirati paket',
              confirmButtonText: 'Da',
              showCancelButton: true,
              cancelButtonText: 'Ne',
              type: 'warning'
          }).then((confirm)=>{
              sweetAlert({
                  title: 'Paket je postao neaktivan',
                  confirmButtonText: 'OK',
                  type: 'success'
              }).then((confirm)=>{
                this.get('_packageService').deactivatePackage(packageId).then(()=>{
                  this.set('packageId', null);
                  this.get('target.router').refresh();  
                })
                })
          })
      },
  
  }
});
