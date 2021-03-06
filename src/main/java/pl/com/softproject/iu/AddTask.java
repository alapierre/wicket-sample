/*
 * Copyright 2014 Adrian Lapierre <adrian@softproject.com.pl>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.softproject.iu;

import java.util.Date;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import pl.com.softproject.dao.TaskDAO;
import pl.com.softproject.model.Task;
import pl.com.softproject.service.HelloService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class AddTask extends WebPage {

    private Task task = new Task();
    
    @SpringBean
    private HelloService helloService;
    
    @SpringBean
    private TaskDAO taskDAO;

    public AddTask() {

        TextField nameField = new TextField("name", new PropertyModel(task, "name"));
        TextField descriptionField = new TextField("description", new PropertyModel(task, "description"));

        //DatePicker datePickerField = new DatePicker();
        
        DateTextField dateTextField = new DateTextField("doDate", new PropertyModel<Date>(
            task, "doDate"),  new StyleDateConverter("S-", false));
        dateTextField.add(new DatePicker());
        
        Form form = new LoginForm("taskForm");
        form.add(nameField);
        form.add(descriptionField);
        form.add(dateTextField);
        add(form);
        
        System.out.println(helloService);

    }

    class LoginForm extends Form {

        public LoginForm(String id) {
            super(id);
        }

        @Override
        public void onSubmit() {
            System.out.println("submit");
            System.out.println(task);
            
            taskDAO.save(task);
            
            TaskAdded page = new TaskAdded();
            setResponsePage(page);
        }

    }
}
