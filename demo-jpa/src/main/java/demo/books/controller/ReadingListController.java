package demo.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.books.entities.Book;
import demo.books.repositories.ReadingListRepository;
import demo.conf.AmazonConfig;
import demo.security.entity.Reader;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

	private ReadingListRepository readingListRepository;
	private AmazonConfig amazonConfig;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository, AmazonConfig amazonConfig) {
		this.readingListRepository = readingListRepository;
		this.amazonConfig = amazonConfig;
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		if (readingList != null) {
			model.addAttribute("books", readingList);
			model.addAttribute("reader", reader);
			model.addAttribute("amazonID", amazonConfig.getAssociateId());
		}
		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/readingList";
	}
}