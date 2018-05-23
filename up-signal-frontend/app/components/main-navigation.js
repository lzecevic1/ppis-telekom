import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';

export default Ember.Component.extend(SweetAlertMixin, {
    session: Ember.inject.service('session'),
    router: Ember.inject.service('-routing'),
    classNames: ['main-navigation'],
    actions: {
        logout() {
            let sweetAlert = this.get('sweetAlert');
            sweetAlert({
                title: 'Jeste li sigurni da se želite odjaviti?',
                confirmButtonText: 'Da',
                showCancelButton: true,
                cancelButtonText: 'Ne',
                type: 'warning'
            }).then((confirm)=>{
                sweetAlert({
                    title: 'Uspješno ste se odjavili',
                    confirmButtonText: 'OK',
                    type: 'success'
                }).then((confirm)=>{
                    this.get('session').invalidate();
                    this.get('router').transitionTo('homepage');
                })
            })
        },
    }
});
