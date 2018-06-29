



public class ${classname}{



        <#list attrs as value >

         private  ${value.type} ${value.name};


        </#list>

        <#list attrs as value >

        public ${value.type}  get${value.name}(){

                return this.${value.name};
        }

        public void  set${value.name}(${value.type}  ${value.name}){

                this.${value.name}= ${value.name};
        }

        </#list>


}