/**
 * call all item rest API 
 */

let baseURL = "http://localhost:8080"

var getAllItems = function(){
    return axios.get('http://localhost:8080/bestby/items');
 }

 

/**
 * register the component. 
 * list : gets the array list of items.
 * columns : specify the column names 
 */
 Vue.component('best-by', {    
    template: '#myTemplate',
    props:{
        list: Array,
        columns: Array
    }       
  })

new Vue({
    el: '#app',    
    data:{
        itemName:'',
        itemColumns : ['Id','Item','BestBy Date'],
        items: []
    },
    created:function() {
        // This code will run on startup
        // fetch all bestby items
        getAllItems()
             .then(response => {this.items = response.data})        
        .catch((error) => {
            console.log(error);
        });
    },
    methods:{
        create: function(){
            console.log('create is clicked')
            axios.post('bestby/create',{
                "item":this.itemName,
                "bestByDate":moment().format()    
            })
            .then(response => {
                console.log('create response -> '+response)
                getAllItems().then(response => {this.items = response.data })
               
            })        
            .catch((error) => {
                console.log(error);
            });
        }
      } // end of methods
}) // end of Vue instance.


