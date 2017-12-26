/**
 * call all item rest API 
 */
var getAllItems = function(){
    return axios.get('/bestby/items');
 }

new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        itemName:'',        
        items: [{
            id:0,
            item:'testItem',
            timeStamp:232323223

        }]
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
      }
}) // end of Vue instance. 



