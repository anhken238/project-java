package com.codegym.controller;


import com.codegym.model.Category;
import com.codegym.model.Note;
import com.codegym.service.CategoryService;
import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView goHome(){
        ModelAndView modelAndView = new ModelAndView("/home/homes");
        return modelAndView;
    }

    // show list post
    @GetMapping("/list")
    public ModelAndView listNotes(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Note> notes;
        if (s.isPresent()) {
            notes = noteService.findAllByPostNameContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/note/list-note");
        modelAndView.addObject("notes", notes);
        return modelAndView;

    }

    // create
    @GetMapping("/create-note")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/note/create-note");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView saveCreateNote(@Validated @ModelAttribute("note") Note note, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/note/create-note");
            return modelAndView;
        }
        else{
            noteService.save(note);
            ModelAndView modelAndView = new ModelAndView("/note/create-note");
            modelAndView.addObject("note", new Note());
            modelAndView.addObject("message", "create note was success");
            return modelAndView;
        }
    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public ModelAndView updateNote(@Validated @ModelAttribute("note") Note note,BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            return modelAndView;
        }
        else {
            noteService.save(note);
            ModelAndView modelAndView = new ModelAndView("/note/create-note");
            modelAndView.addObject("note", new Note());
            modelAndView.addObject("message", "create note was success");
            return modelAndView;
        }

    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/delete");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-note")
    public String deleteNote(@ModelAttribute("note") Note note){
        noteService.remove(note.getId());
        return "redirect:list";
    }

    @GetMapping("/view-note/{id}")
    public String viewNote(@PathVariable Long id, Model model){

        Note notes = noteService.findById(id);
        model.addAttribute("note", notes);
        return "/note/view-note";
    }
}
