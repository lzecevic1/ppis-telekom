import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';
export default Ember.Controller.extend(SweetAlertMixin, {
    session: Ember.inject.service(),
    model: {},
    errorMessage: '',
    actions: {
      login() {
        let sweetalert = this.get('sweetAlert');
        this.get('session').authenticate('authenticator:application', this.model, (data) => {
                Ember.set(this, 'errorMessage', '');
                Ember.set(this, 'model', {});
                sweetalert({
                    title: 'Uspješna prijava',
                    confirmButtonText: 'OK',
                    type: 'success'
                }).then((confirm)=>{
                    this.transitionToRoute('homepage');
                })
            })
            .catch(reason => {
                Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                this.set('authenticationError', this.errorMessage || reason);
                sweetalert({
                    title: 'Pogrešan username ili password',
                    confirmButtonText: 'Pokušajte ponovo',
                    type: 'error'
                })
            });
},
        onCancel: function () {
          this.transitionToRoute('/');
        },
    }
});
